package com.deepthought.home

import com.deepthought.bridge.GetPaidExpendituresUseCase
import com.deepthought.bridge.GetScheduledExpendituresUseCase
import com.deepthought.bridge.GetTodayExpendituresUseCase
import com.deepthought.bridge.GetUserNameUseCase
import com.deepthought.bridge.model.Expenditure
import com.deepthought.bridge.model.ExpenditureCategory
import dohun.kim.kinda.kinda_android.KindaViewModel
import dohun.kim.kinda.kinda_android_test.KindaViewModelTest
import junit.framework.Assert.*
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*

class HomeViewModelTest : KindaViewModelTest<HomeState, HomeEvent, HomeSideEffect>() {

    @Mock
    private lateinit var getUserNameUseCase: GetUserNameUseCase

    @Mock
    private lateinit var getPaidExpendituresUseCase: GetPaidExpendituresUseCase

    @Mock
    private lateinit var getScheduledExpendituresUseCase: GetScheduledExpendituresUseCase

    @Mock
    private lateinit var getTodayExpenditures: GetTodayExpendituresUseCase

    override fun buildViewModel(): KindaViewModel<HomeState, HomeEvent, HomeSideEffect> {
        return HomeViewModel(
            getUserName = getUserNameUseCase,
            getPaidExpenditures = getPaidExpendituresUseCase,
            getScheduledExpenditures = getScheduledExpendituresUseCase,
            getTodayExpenditures = getTodayExpenditures
        )
    }

    @Test
    fun `AttemptGetExpenditures, Dispatch GetExpenditures side effect`(): Unit = runBlocking {
        viewModel.intent(HomeEvent.AttemptGetExpenditures)

        verify(getPaidExpendituresUseCase, atLeast(2)).invoke(false)
        verify(getScheduledExpendituresUseCase, atLeast(2)).invoke(false)
        verify(getTodayExpenditures, atLeast(2)).invoke(false)
    }

    @Test
    fun `AttemptGetExpenditures, Has no expenditure, Set hasExpenditure to false`(): Unit =
        runBlocking {
            `when`(getPaidExpendituresUseCase.invoke(false)).thenReturn(emptyList())
            `when`(getScheduledExpendituresUseCase.invoke(false)).thenReturn(emptyList())
            `when`(getTodayExpenditures.invoke(false)).thenReturn(emptyList())

            HomeEvent.AttemptGetExpenditures expectState {
                assertFalse(it.hasExpenditure)
            }
        }

    @Test
    fun `AttemptGetExpenditures, Get expenditures from use cases, Set expenditures`(): Unit =
        runBlocking {
            `when`(getPaidExpendituresUseCase.invoke(false)).thenReturn(paidExpenditures)
            `when`(getScheduledExpendituresUseCase.invoke(false)).thenReturn(scheduledExpenditures)
            `when`(getTodayExpenditures.invoke(false)).thenReturn(todayExpenditures)

            HomeEvent.AttemptGetExpenditures expectState {
                assertEquals(paidExpenditures, it.paidExpenditures)
                assertEquals(scheduledExpenditures, it.scheduledExpenditures)
                assertEquals(todayExpenditures, it.todayExpenditures)
                assertTrue(it.hasExpenditure)
            }
        }

    @Test
    fun `AttemptGetExpenditures, Get expenditures from use cases, Set totalPrice(sum of price)`(): Unit =
        runBlocking {
            `when`(getPaidExpendituresUseCase.invoke(false)).thenReturn(paidExpenditures)
            `when`(getScheduledExpendituresUseCase.invoke(false)).thenReturn(scheduledExpenditures)
            `when`(getTodayExpenditures.invoke(false)).thenReturn(todayExpenditures)

            HomeEvent.AttemptGetExpenditures expectState {
                assertEquals(6000, it.totalExpenditure)
            }
        }

    @Test
    fun `SetUserName, User name is blank, Navigate to input name`() = runBlocking {
        `when`(getUserNameUseCase.invoke()).thenReturn("")

        HomeEvent.SetUserName expectState {
            assertNotNull(it.navigateInputName.peekData())
        }
    }

    @Test
    fun `SetUserName, User name is dohun, Set userName state to dohun`(): Unit = runBlocking {
        `when`(getUserNameUseCase.invoke()).thenReturn("dohun")

        HomeEvent.SetUserName expectState {
            assertEquals("dohun", it.userName)
        }
    }

    companion object {
        private val paidExpenditures = listOf(
            Expenditure(1, "지출1", 1000, ExpenditureCategory(0, "카테고리1"))
        )
        private val scheduledExpenditures = listOf(
            Expenditure(2, "지출2", 2000, ExpenditureCategory(0, "카테고리1"))
        )
        private val todayExpenditures = listOf(
            Expenditure(3, "지출3", 3000, ExpenditureCategory(0, "카테고리1"))
        )
    }
}
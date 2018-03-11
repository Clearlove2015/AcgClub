package com.rabtman.acgcomic.mvp

import com.rabtman.acgcomic.mvp.model.entity.*
import com.rabtman.common.base.mvp.IModel
import com.rabtman.common.base.mvp.IView
import io.reactivex.Completable
import io.reactivex.Flowable

/**
 * @author Rabtman
 * 漫画模块所有契约类
 */

interface DmzjComicContract {

    interface View : IView {
        fun showComicInfos(comicInfos: List<DmzjComicItem>)

        fun showMoreComicInfos(comicInfos: List<DmzjComicItem>, canLoadMore: Boolean)

        fun onLoadMoreFail()
    }

    interface Model : IModel {
        fun getComicInfos(selected: String): Flowable<List<DmzjComicItem>>
    }
}

interface OacgComicContract {

    interface View : IView {
        fun showComicInfos(comicInfos: List<OacgComicItem>?)

        fun showMoreComicInfos(comicInfos: List<OacgComicItem>?, canLoadMore: Boolean?)

        fun showSearchComicInfos(comicInfos: List<OacgComicItem>?)

        fun onLoadMoreFail()
    }

    interface Model : IModel {
        fun getComicInfos(themeId: Int, pageNo: Int): Flowable<OacgComicPage>

        fun getSearchComicInfos(keyword: String): Flowable<OacgComicPage>
    }
}

interface OacgComicDetailContract {

    interface View : IView {
        fun showComicDetail(comicInfos: List<OacgComicEpisode>?)

        fun showCollectView(isCollected: Boolean)
    }

    interface Model : IModel {
        fun getComicDetail(comicId: Int): Flowable<List<OacgComicEpisode>>

        fun getLocalOacgComicItemById(comicInfoId: String): Flowable<OacgComicItem>

        fun addOrDeleteLocalOacgComicItem(comicInfo: OacgComicItem, isAdd: Boolean): Completable
    }
}

interface OacgComicEpisodeDetailContract {

    interface View : IView {
        fun showEpisodeDetail(episodePage: OacgComicEpisodePage)
    }

    interface Model : IModel {
        fun getEpisodeDetail(comicId: Int, chapterIndex: Int): Flowable<OacgComicEpisodePage>
    }
}

